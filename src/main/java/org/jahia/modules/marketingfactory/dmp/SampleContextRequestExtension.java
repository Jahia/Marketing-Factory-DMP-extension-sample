package org.jahia.modules.marketingfactory.dmp;

import org.apache.unomi.api.*;
import org.jahia.api.Constants;
import org.jahia.modules.marketingfactory.filters.ssr.extension.UnomiRequestListener;
import org.jahia.services.render.RenderContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component(service = UnomiRequestListener.class, immediate = true)
public class SampleContextRequestExtension implements UnomiRequestListener {

    @Override
    public void beforeUnomiRequest(ContextRequest contextRequest, RenderContext renderContext) {
        if (Constants.LIVE_WORKSPACE.equals(renderContext.getMode())) {
            String siteKey = renderContext.getSite().getSiteKey();

            Item source = new CustomItem();
            source.setScope(siteKey);
            source.setItemId("wemProfile");
            source.setItemType("wemProfile");

            Event event = new Event("updateProperties", null, new Profile(), siteKey, source, null, new Date());

            Map<String, Object> map = new HashMap<>();
            map.put("properties.dmpSample","dmpSampleValue");

            event.setProperty("update", map);
            event.setProperty("targetType", Profile.ITEM_TYPE);

            contextRequest.getEvents().add(event);
        }
    }
}
